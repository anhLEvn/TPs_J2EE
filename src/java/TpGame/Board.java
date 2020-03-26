/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpGame;

/**
 *
 * @author user
 */
public class Board {
    private int x;
    private int y;
    public Integer[][] matrix;
    public Board(int x, int y){
        this.x = x; this.y=y;
        matrix = new Integer[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }
    
    
    
    
}
