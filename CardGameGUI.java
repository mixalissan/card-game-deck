

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardGameGUI extends JFrame {
    private ArrayList<card> deck;
    private JPanel cardPanel;

    public CardGameGUI() {
        Game game = new Game();
        deck = game.begin();

        // Set up the JFrame
        setTitle("Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set a fixed size for the JFrame
        setSize(1000, 800); // Set your desired width and height

        // Create a panel with GridLayout to display 8 cards
        cardPanel = new JPanel(new GridLayout(2, 4));
        add(cardPanel, BorderLayout.CENTER);

        // Display initial 8 cards
        displayInitialCards();

        // Create a button to draw new cards
        JButton drawButton = new JButton("Draw New Cards");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceSelectedCards();
            }
        });
        add(drawButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayInitialCards() {
        for (int i = 0; i < 8; i++) {
            if (!deck.isEmpty()) {
                card drawnCard = deck.remove(0);
                addCardToPanel(drawnCard);
            }
        }
    }

    private void replaceSelectedCards() {
        for (Component component : cardPanel.getComponents()) {
            if (component instanceof CardLabel && ((CardLabel) component).isSelected()) {
                cardPanel.remove(component);
                if (!deck.isEmpty()) {
                    card drawnCard = deck.remove(0);
                    addCardToPanel(drawnCard);
                }
            }
        }
        cardPanel.revalidate();
        cardPanel.repaint();
    }

    private void addCardToPanel(card drawnCard) {
        CardLabel cardLabel = new CardLabel(drawnCard);
        cardLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLabel.toggleSelected();
            }
        });
        cardPanel.add(cardLabel);
    }

    private class CardLabel extends JButton {
        private card associatedCard;
        private boolean selected;

        public CardLabel(card associatedCard) {
            this.associatedCard = associatedCard;
            this.selected = false;
      
            int newWidth = 200; 
            int newHeight = 300;
        
            ImageIcon cardImage = new ImageIcon(new ImageIcon(associatedCard.getPath()).getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
            setIcon(cardImage);
        }

        public void toggleSelected() {
            selected = !selected;
            if (selected) {
                setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
            } else {
                setBorder(null);
            }
        }

        public boolean isSelected() {
            return selected;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CardGameGUI());
    }
}
