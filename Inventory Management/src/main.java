import javax.swing.JFrame;

public class main 
{
    public static void main(String[] args) throws Exception
    {
        guiFrame framee = new guiFrame();

        framee.setVisible(true);
        framee.setLocationRelativeTo(null);
        framee.setSize(1150,700);
        framee.setTitle("Stock/Inventory Managment");
        framee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }
}
