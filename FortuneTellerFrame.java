import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, titlePnl, displayPnl, cmdPnl;
    JLabel titleLbl;
    ImageIcon icon;
    JScrollPane scroller;
    JTextArea fortuneTa;
    JButton quitBtn, fortuneBtn;

    JTextArea textArea;

    String[] fortunes = {
            "You will win $1 million",
            "You will win a new car",
            "You will get your dream job",
            "You will make a new friend",
            "You will get great grades",
            "Good fortune is coming your way",
            "All your debt will soon be forgiven",
            "You will soon satisfy your hunger",
            "You will soon learn to say the ABC's backwards",
            "Food will no longer be an issue for you",
            "Life will get better",
            "Never give up, others rely on you"};

    int currentFortuneIndex = -1;
    Random rnd = new Random();
    int newDex = 1;
    public FortuneTellerFrame()
    {

        setTitle("Fortune Teller");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createCommandPanel();



        setVisible(true);
    }

    private void createTitlePanel()
    {
        titlePnl = new JPanel();
        titlePnl.setPreferredSize(new Dimension(100,300));
        titleLbl = new JLabel("Fortune Teller");
        icon = new ImageIcon("src/fortune.jpg", null);
        titleLbl.setIcon(icon);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.NORTH);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 35));

        titlePnl.add(titleLbl);

        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        fortuneTa = new JTextArea(10,60);
        scroller = new JScrollPane(fortuneTa);
        fortuneTa.setFont(new Font("Times New Roman", Font.BOLD, 15));

        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    private void createCommandPanel()
    {
        cmdPnl = new JPanel();
        cmdPnl.setLayout(new GridLayout(1,2));
        cmdPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));
        quitBtn = new JButton("Quit");
        fortuneBtn = new JButton("Get a fortune");
        quitBtn.setFont(new Font("Arial", Font.ITALIC, 20));
        fortuneBtn.setFont(new Font("Arial", Font.ITALIC, 20));

        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            do {
                newDex = rnd.nextInt(fortunes.length);
            } while (newDex == currentFortuneIndex);

            currentFortuneIndex = newDex;

            fortuneTa.append(fortunes[currentFortuneIndex] + "\n");


        });

        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        mainPnl.add(cmdPnl, BorderLayout.SOUTH);
    }
}
