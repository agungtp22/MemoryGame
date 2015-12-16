import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;   
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class MemoryGame 
implements ActionListener, MouseListener{
	private JFrame frame = new JFrame();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JLabel kartu[] = new JLabel[16];
	private JButton[] gameBtn = new JButton[16];
	private ImageIcon latarKartu = new ImageIcon("yugioh.jpg");
	private JButton btnMulai = new JButton("Mulai Baru");
	private JButton btnSimpan =  new JButton("Simpan");
	private JButton btnBuka = new JButton("Buka");
	public int score = 0;
    public int level = 1;
    private JLabel labelLevel = new JLabel("Your Level");
    private JLabel labelLevelAngka = new JLabel("1");
	private JLabel labelScore = new JLabel("Your Score");
	private JLabel labelScoreAngka = new JLabel("0");
	private JFileChooser fileChooser = new JFileChooser();
    private String namaFile="";
	public RandomGen rg = new RandomGen();
	public ArrayList<Integer> angka = new ArrayList<Integer>();
	private int counter = 0;
    private int pasanganSama=0;
    int indexPertama = 0;
    int indexKeDua = 0;

     Timer myTimer;
    
    static String gambar[] = {"caillou.JPG", "daddy.JPG",
        "mommy.JPG", "Cat.JPG",
        "rosy.JPG", "teddy.JPG","image.jpg","image.PNG"};
	
	public void buildPanel(){
		leftPanel.setPreferredSize(new Dimension(200,600));
		rightPanel.setPreferredSize(new Dimension(590,600));
		leftPanel.setBackground(Color.gray);
		rightPanel.setBackground(Color.darkGray);
		frame.add(leftPanel,BorderLayout.WEST);
		frame.add(rightPanel,BorderLayout.EAST);
	}
	public void rightSideComponent(){

		
 		rightPanel.setLayout(new GridLayout(4, 4,20,20));
 		
 		rg.isiAwal();
 		angka = rg.getAngka();
        for (int i = 0,j=1; i < kartu.length; i++)
        {
        	//gameBtn[i] = new JButton();
        	kartu[i] =  new JLabel();
        	kartu[i].setOpaque(true);
        	kartu[i].setVerticalAlignment(SwingConstants.CENTER);
        	kartu[i].addMouseListener(this);
            //kartu[i].setPreferredSize(new Dimension(125,125));
        	kartu[i].setFont(new Font("Serif", Font.PLAIN, 32));
			kartu[i].setHorizontalAlignment(SwingConstants.CENTER);

			//gameBtn[i].addActionListener(this);
        	//kartu[i].setText(""+angka.get(i));
        	//kartu[i].setIcon(latarKartu);
  
        }
        for(int i = 0; i< kartu.length; i++){
        	rightPanel.add(kartu[i]);
        }

        myTimer = new Timer(500, new TimerListener());
	}

	public void leftSideComponent(){
		leftPanel.add(labelScore);
		leftPanel.add(labelScoreAngka);
        leftPanel.add(labelLevel);
        leftPanel.add(labelLevelAngka);
		leftPanel.add(btnMulai);
		leftPanel.add(btnSimpan);
		leftPanel.add(btnBuka);

		labelScore.setFont(new Font("Serif", Font.PLAIN, 32));
		labelScore.setPreferredSize(new Dimension(200,30));
		labelScore.setVerticalAlignment(SwingConstants.CENTER);
		labelScore.setHorizontalAlignment(SwingConstants.CENTER);

		labelScoreAngka.setFont(new Font("Serif", Font.PLAIN, 32));
		labelScoreAngka.setPreferredSize(new Dimension(200,30));
		labelScoreAngka.setVerticalAlignment(SwingConstants.CENTER);
		labelScoreAngka.setHorizontalAlignment(SwingConstants.CENTER);

        labelLevel.setFont(new Font("Serif", Font.PLAIN, 32));
        labelLevel.setPreferredSize(new Dimension(200,30));
        labelLevel.setVerticalAlignment(SwingConstants.CENTER);
        labelLevel.setHorizontalAlignment(SwingConstants.CENTER);

        labelLevelAngka.setFont(new Font("Serif", Font.PLAIN, 32));
        labelLevelAngka.setPreferredSize(new Dimension(200,30));
        labelLevelAngka.setVerticalAlignment(SwingConstants.CENTER);
        labelLevelAngka.setHorizontalAlignment(SwingConstants.CENTER);

		btnMulai.setFont(new Font("Serif", Font.PLAIN, 16));
		btnMulai.setPreferredSize(new Dimension(180,30));
		btnMulai.setVerticalAlignment(SwingConstants.CENTER);
		btnMulai.setHorizontalAlignment(SwingConstants.CENTER);

		btnSimpan.setFont(new Font("Serif", Font.PLAIN, 16));
		btnSimpan.setPreferredSize(new Dimension(180,30));
		btnSimpan.setVerticalAlignment(SwingConstants.CENTER);
		btnSimpan.setHorizontalAlignment(SwingConstants.CENTER);

		btnBuka.addActionListener(this);
		btnMulai.addActionListener(this);
		btnSimpan.addActionListener(this);

		btnBuka.setFont(new Font("Serif", Font.PLAIN, 16));
		btnBuka.setPreferredSize(new Dimension(180,30));
		btnBuka.setVerticalAlignment(SwingConstants.CENTER);
		btnBuka.setHorizontalAlignment(SwingConstants.CENTER);
	}
	


    public void updateScore(){
    	score +=100;
    	labelScoreAngka.setText(""+score);
        if(score % 1000 == 0){
            updateLevel();
             JOptionPane.showMessageDialog(frame, "Selamat anda naik ke Level "+ level);
            labelScoreAngka.setText("0");
            removeLabel();
            mulaiBaru();     
        }
    }
    public void updateLevel(){
        level +=1;
        labelLevelAngka.setText(""+level);
    }
	 public void actionPerformed(ActionEvent e)
	
    {
    	if(btnMulai == e.getSource()){
            removeLabel();
    		mulaiBaru();
    	}
        if(btnSimpan == e.getSource()){
           simpanGame();
           // System.out.println(name);
        }
        if(btnBuka == e.getSource()){
            bukaGame();
        }

    	
    }


    @Override
     public void mousePressed(MouseEvent e) {
       //System.out.println("1");
    }
    public void mouseReleased(MouseEvent e) {
     
    }
 
    public void mouseEntered(MouseEvent e) {
        //for(int i = 0; i< kartu.length; i++){
          //  if(kartu[i] == e.getSource()){
            //    kartu[i].setIcon(new ImageIcon(gambar[angka.get(i)]));
           // }
        //}       
    }
 
    public void mouseExited(MouseEvent e) {
      // for(int i = 0; i< kartu.length; i++){
        //    if(kartu[i] == e.getSource()){
          //      kartu[i].setIcon(latarKartu);
           // }
       // }  
    }
 
    public void mouseClicked(MouseEvent e) {

 		 if (myTimer.isRunning()) return;
        counter++;
        for (int i = 0; i < angka.size(); i++) {
            if (e.getSource() == kartu[i]) {
                kartu[i].setText(""+angka.get(i));
                indexPertama = i;
            }
        }
        
        if (counter % 2 == 0) {
            if (indexPertama == indexKeDua) {
                counter--;
                return;
            }
            if (angka.get(indexPertama) != angka.get(indexKeDua)) {
                myTimer.start(); 
            }else{
                pasanganSama++;
                updateScore();
                if(pasanganSama % 8 == 0){
                    removeLabel();
                    mulaiBaru();
                }
            }
        } else {
            indexKeDua = indexPertama;
        }
    }

    public void removeLabel(){
        for(int i=0; i< angka.size(); i++){
            rightPanel.remove(kartu[i]);
        }
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    public void mulaiBaru(){
        rg.isiAwal();
        
    	for(int i = 0; i < angka.size(); i++){
    		kartu[i] =  new JLabel();
            kartu[i].setOpaque(true);
            kartu[i].setVerticalAlignment(SwingConstants.CENTER);
            kartu[i].addMouseListener(this);
            kartu[i].setFont(new Font("Serif", Font.PLAIN, 32));
            kartu[i].setHorizontalAlignment(SwingConstants.CENTER);
            rightPanel.add(kartu[i]);
    	}
        //angka.clear();
        angka = rg.getAngka();
    	
    }

    public void simpanGame(){
         namaFile=JOptionPane.showInputDialog(frame,
                        "Enter Your Saved Game Name", "Save Game",1);

        try{
        FileWriter pw = new FileWriter("savedgame/"+namaFile+".dat");
        pw.write(""+score+"\r\n");//simpan score
        pw.write(""+level+"\r\n");//simpan level
            for(Integer anka: angka) {
              pw.write(""+anka+"\r\n"); //simpan posisi
            }
          
            pw.close();
            JOptionPane.showMessageDialog(frame, ""+ namaFile +" Berhasil Disimpan");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void bukaGame(){
        for(int i = 0; i<angka.size(); i++){
            System.out.println(angka.get(i));
        }
        
        JFileChooser fileopen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter(".dat", "dat");
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileopen.setCurrentDirectory(workingDirectory);
        fileopen.addChoosableFileFilter(filter);
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
          File file = fileopen.getSelectedFile();
         
          angka.clear();
          //System.out.println(file);
          try{
            BufferedReader r = new BufferedReader(new FileReader(file));
                for (int i = 0; i < 1; i++)
                {
                    //labelLevelAngka.setText(""+level);
                   labelScoreAngka.setText(r.readLine());
                }
                for (int i = 1; i < 2; i++)
                {
                   labelLevelAngka.setText(r.readLine());
                }
                for(int i=2,j=0; i< 18; i++){
                     angka.add(Integer.parseInt(r.readLine()));
                }
                JOptionPane.showMessageDialog(frame, ""+ file +" Berhasil di Load");
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
	public MemoryGame(){
		//myGui();
		rightSideComponent();
		leftSideComponent();
	
		buildPanel();
		frame.setTitle("Memory Game By AgungTepe");
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            kartu[indexPertama].setText("");
            kartu[indexKeDua].setText("");
            kartu[indexPertama].setEnabled(true);
            kartu[indexKeDua].setEnabled(true);
            myTimer.stop();
        }
    }
	public static void main(String[] args){
		new MemoryGame();
	}

}