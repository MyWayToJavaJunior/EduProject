package ru.testtask.dao;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testtask.model.Address;

/**
 * Created by nikolay on 03/10/17.
 */
public class AddressDAOTest {
    /**
     * address dao.
     */
    private AddressDAO addressDAO;
    /**
     * address 1.
     */
    private Address address;
    /**
     * address 2.
     */
    private Address address2;
    /**
     * before.
     */
    @Before
    public void before() {
        address = new Address(12345, "SPb", "Lenina", 17);
        addressDAO = new AddressDAO();
        addressDAO.add(address);
    }
    /**
     * test.
     */
    @Test
    public void addAndGetByNameTest() {
        address2 = new Address(54321, "Moscow", "Red square", 1);
        addressDAO.add(address2);
        Address addr = addressDAO.getOne(address2);
        Assert.assertThat(addr.getCity(), Is.is(address2.getCity()));
        Assert.assertThat(addr.getStreet(), Is.is(address2.getStreet()));
        Assert.assertThat(addr.getNumber(), Is.is(address2.getNumber()));
        addressDAO.delete(address);
        addressDAO.delete(address2);
    }
    /**
     * test.
     */
    @Test
    public void editTest() {
        Address temp = addressDAO.getOne(address);
        Address editAddr = new Address(temp.getId(), "Voronezh", "Truda", 156);
        addressDAO.edit(editAddr);

        Address addr = addressDAO.getOne(editAddr);

        Assert.assertThat(addr.getCity(), Is.is("Voronezh"));
        Assert.assertThat(addr.getStreet(), Is.is("Truda"));
        Assert.assertThat(addr.getNumber(), Is.is(editAddr.getNumber()));

        addressDAO.delete(editAddr);
    }
    /**
     * test.
     */
    @Test
    public void deleteTest() {
        addressDAO.delete(address);
        Address nullAddr = addressDAO.getOne(address);
        Assert.assertNull(nullAddr);
    }
}
