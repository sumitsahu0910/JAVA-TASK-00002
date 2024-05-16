import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuoteofTheDayApp extends JFrame {
    private String[] quotes = {
            "The only way to do great work is to love what you do. - Steve Jobs",
            "Life is what happens when you're busy making other plans. - John Lennon",
            "In the end, it's not the years in your life that count. It's the life in your years. - Abraham Lincoln",
            "The only impossible journey is the one you never begin. - Tony Robbins",
            "The best time to plant a tree was 20 years ago. The second best time is now. - Chinese Proverb"
    };

    private JLabel quoteLabel;
    private JButton newQuoteButton;

    public QuoteofTheDayApp() {
        setTitle("Quote of the Day");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        quoteLabel = new JLabel(getRandomQuote());
        quoteLabel.setHorizontalAlignment(JLabel.CENTER);

        newQuoteButton = new JButton("New Quote");
        newQuoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quoteLabel.setText(getRandomQuote());
            }
        });

        add(quoteLabel, BorderLayout.CENTER);
        add(newQuoteButton, BorderLayout.SOUTH);
    }

    private String getRandomQuote() {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuoteofTheDayApp().setVisible(true);
            }
        });
    }
}