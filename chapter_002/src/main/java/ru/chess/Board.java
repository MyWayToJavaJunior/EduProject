package ru.chess;

/**
 * Created by nik on 3/26/2017.
 */

// Первый ряд: rook (ладья) , knight (конь) , bishop (слон) , queen (ферзь) , king (король).
// Пешки-the pawns
public class Board {
    /**
     * Array of figures on board.
     */
    private Figure[] figures;
    /**
     * Constructor of board.
     * @param figures - Array of figures on board.
     */
    public Board(Figure[] figures) {
        this.figures = figures;
    }
    /**
     * Get move on board.
     * @param source - figure to move.
     * @param dist - distination of move.
     * @return - result of move.
     * @throws ImposibleMoveException - imposible to move.
     * @throws OccupiedWayException - occupied this way.
     * @throws FigureNotFoundException - figure not found.
     */
    boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean figureFound = false;
        boolean result = false;
        int pos = 0;
        Figure f = null;
        for (; pos < this.figures.length; pos++) {
            if (source.getX() == figures[pos].getPosition().getX() && source.getY() == figures[pos].getPosition().getY()) {
                figureFound = true;
                f = figures[pos];
                break;
            }
        }

        if (!figureFound) {
            throw new FigureNotFoundException("Figure not found.");
        }

        if (source.getY() < 0 || source.getY() > 9 || source.getX() < 0 || source.getX() > 9
                || dist.getY() < 0 || dist.getY() > 9 || dist.getX() < 0 || dist.getX() > 9) {
            throw new ImposibleMoveException("Imposible to move.");
        }

        Cell[] way = f.way(dist);

        if(!(f instanceof Knight)) {
            for (int i = 0; i < figures.length; i++) {
                for (int j = 0; j < way.length; j++) {
                    if (figures[i].getPosition().equals(way[j])) {
                        throw new OccupiedWayException("Way is occupied.");
                    }
                }
            }
        }

        figures[pos] = f.clone(dist);
        result = true;

        return result;
    }

//    public static void main(String[] args) {
//        Cell bishopStart = new Cell(1,1);
//        Cell other = new Cell(4,1);
//        Rook bishop = new Rook(bishopStart);
//        Rook bishop1 = new Rook(other);
//        Figure[] figures = new Figure[] {bishop, bishop1};
//        Board board = new Board(figures);
//
//        Cell sell01 = new Cell(1,1);
//        Cell sell02 = new Cell(1,6);
//
//        try {
//            board.move(sell01, sell02);
//        } catch (ImposibleMoveException ime) {
//            System.out.println("Imposibnle to move.");
//        } catch (OccupiedWayException owe) {
//            System.out.println("Way is occupied.");
//        } catch (FigureNotFoundException fnf) {
//            System.out.println("Figure not found.");
//        }
//    }
}
