package ru.testtask.dao;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testtask.model.MusicType;

/**
 * Created by nikolay on 03/10/17.
 */
public class MusicTypeDAOTest {
    /**
     * music dao.
     */
    private MusicTypeDAO musicTypeDAO;
    /**
     * music 1.
     */
    private MusicType testType1;
    /**
     * music 2.
     */
    private MusicType testType2;
    /**
     * before.
     */
    @Before
    public void before() {
        testType1 = new MusicType("TestType", "Desc");
        musicTypeDAO = new MusicTypeDAO();
        musicTypeDAO.add(testType1);
    }
    /**
     * controller.
     */
    @Test
    public void addAndGetByNameTest() {
        testType2 = new MusicType("Test", "Description");
        musicTypeDAO.add(testType2);
        MusicType musicType = musicTypeDAO.getOne(testType2);
        Assert.assertThat(musicType.getType(), Is.is("Test"));
        musicTypeDAO.delete(testType1);
        musicTypeDAO.delete(testType2);
    }
    /**
     * controller.
     */
    @Test
    public void editTest() {
        MusicType edited = new MusicType("TestType", "New description");
        musicTypeDAO.edit(edited);
        MusicType musicType = musicTypeDAO.getOne(edited);
        Assert.assertThat(musicType.getDescription(), Is.is("New description"));
        musicTypeDAO.delete(testType1);
    }
    /**
     * controller.
     */
    @Test
    public void deleteTest() {
        MusicType deleted = new MusicType("TestType", "");
        musicTypeDAO.delete(deleted);
        MusicType musicType = musicTypeDAO.getOne(deleted);
        Assert.assertNull(musicType);
    }
}
