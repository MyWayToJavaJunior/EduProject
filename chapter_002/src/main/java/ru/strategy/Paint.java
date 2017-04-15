package ru.strategy;

/**
 * Created by nik on 3/19/2017.
 */
public class Paint {
    /**
     * Print triangle.
     * @param shape - object of figure to print.
     * @return triangle.
     */
    public String draw(Shape shape) {
        System.out.println(shape.pic());
        return shape.pic();
    }
}
