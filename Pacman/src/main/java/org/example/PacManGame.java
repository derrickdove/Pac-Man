package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PacManGame extends JPanel {
    private static final int TILE_SIZE = 20; // Size of each square tile
    private int[][] board; // Game board

    public PacManGame(int[][] board) {
        this.board = board;
        setPreferredSize(new Dimension(board[0].length * TILE_SIZE, board.length * TILE_SIZE));
        setBackground(Color.BLACK);
    }

    // Method to paint the game state
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 1) { // Wall
                    g.setColor(Color.BLUE);
                    g.fillRect(column * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (board[row][column] == 2) { // Dot
                    g.setColor(Color.WHITE);
                    g.fillOval(column * TILE_SIZE + TILE_SIZE / 4, row * TILE_SIZE + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
                } else if (board[row][column] == 3) { // Pac-Man
                    g.setColor(Color.YELLOW);
                    g.fillArc(column * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE, 45, 270);
                }
            }
        }
    }
    // broken right
    // Move Pac-Man right and repaint
    public void movePacmanRight() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 3) { // Find Pac-Man
                    if (column + 1 < board[row].length && board[row][column + 1] != 1) { // Check if right is not a wall
                        board[row][column] = 0; // Remove Pac-Man from current position
                        board[row][column + 1] = 3; // Place Pac-Man in new position
                        repaint();
                        return;
                    }
                }
            }
        }
    }

    public void movePacmanLeft() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 3) { // Find Pac-Man
                    if (column -1 < board[row].length && board[row][column -1] != 1) { // Check if right is not a wall
                        board[row][column] = 0; // Remove Pac-Man from current position
                        board[row][column - 1] = 3; // Place Pac-Man in new position

                        repaint();
                        return;
                    }
                }
            }
        }
    }
                public void movePacmanUp () {
                    for (int row = 0; row < board.length; row++) {
                        for (int column = 0; column < board[row].length; column++) {
                            if (board[row][column] == 3) { // Find Pac-Man
                                if (row - 1 >= 0  && board[row -1][column] != 1) { // Check if up is not a wall
                                    board[row][column] = 0; // Remove Pac-Man from current position
                                    board[row - 1][column] = 3; // Place Pac-Man in new position

                                    repaint();
                                    return;
                                }
                            }
                        }
                    }
                }

                // broken down
                public void movePacmanDown () {
                    for (int row = 0; row < board.length; row++) {
                        for (int column = 0; column < board[row].length; column++) {
                            if (board[row][column] == 3) { // Find Pac-Man
                                if (row + 1 >= 0 && board[row + 1][column] != 1) { // Check if up is not a wall
                                    board[row][column] = 0; // Remove Pac-Man from current position
                                    board[row + 1][column] = 3; // Place Pac-Man in new position

                                repaint();
                                return;
                            }
                            }
                        }
                    }
                }



                public static void main (String[]args){
                    int[][] initialBoard = {
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                    };


                    SwingUtilities.invokeLater(() -> {
                        JFrame frame = new JFrame("Pac-Man");
                        PacManGame gamePanel = new PacManGame(initialBoard);

                        frame.add(gamePanel);
                        frame.pack();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);

                        frame.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                                    gamePanel.movePacmanRight();
                                }
                                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                                    gamePanel.movePacmanLeft();
                                }
                                if (e.getKeyCode() == KeyEvent.VK_UP) {
                                    gamePanel.movePacmanUp();
                                }
                                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                    gamePanel.movePacmanDown();
                                }
                            }
                        });
                        frame.setFocusable(true);
                        frame.requestFocusInWindow();
                    });
                }
            }



