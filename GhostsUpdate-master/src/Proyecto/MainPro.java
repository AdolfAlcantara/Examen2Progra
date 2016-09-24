package Proyecto;
import ProyectoVisual.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainPro {
	public static Start inicio = new Start();
	public static Login logs = new Login();
	public static Juego game = new Juego();
        public static MenuInicial menuIni = new MenuInicial();
        public static MainMenu main = new MainMenu();
        //public static GameMenu gmenu = new GameMenu();
        
        
        
	public static void main(String[] args){
		logs.Array();
		game.FichasArray();
                main.setVisible(true);
                //gmenu.setVisible(false);
		
		System.out.println("----------Ghosts----------");
		int opcionInicio;
		do{
			opcionInicio = menuIni.bt_MenuIni; //inicio.Starts();
			switch(opcionInicio){
				case 1:
					logs.PrintLogs();
                                        menuIni.bt_MenuIni = 0;
					if(logs.Logins("main")){
                                                //main.setPanel(new GameMenu());
						inicio.MainMens();
					} 
                                        System.out.println("mainpro1");
					break;
				case 2:
					logs.CrearUsu();
                                        menuIni.bt_MenuIni = 0;
					break;
				case 3:
					System.out.println("Adios :)");			
					break;
                                case 0:
                                        break;
				default:
					System.out.println("Error: Comando no valido");
			}
		}while(opcionInicio != 3);
	}
}