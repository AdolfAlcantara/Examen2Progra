package Proyecto;
import java.util.Scanner;
import ProyectoVisual.*;
import ProyectoVisual.PerfilVisual.*;


public class Start {
        MenuInicial menuIni = new MenuInicial();
        GameMenu gmenu = new GameMenu();
        MainMenu main = new MainMenu();
        Configuracion config = new Configuracion();
	Scanner scan = new Scanner(System.in);
        Perfil perf = new Perfil();
	int dificultad = 1;
	boolean modoDeJuegoRandom = true;
	boolean elim = false;
	
	
	public int Starts(){
		System.out.print("--------------------------\n1- Login\n2- Crear Jugador\n3- Salir\n-");
                return menuIni.bt_MenuIni;
	}
	
	public void MainMens(){
		int opcionMainMenu; 	
		do{						
			//System.out.print("--------------------------\n1-Jugar!\n2-Configuracion\n3-Reportes\n4-Mi Perfil\n5-Cerrar Sesion\n-");
			opcionMainMenu = gmenu.bt_gmenu; //scan.nextInt();
			switch(opcionMainMenu){
				case 1:
					MainPro.game.Juegos();
                                        gmenu.bt_gmenu = 0;
					break;
				case 2:
					main.setPanel(new Configuracion());
                                        gmenu.bt_gmenu = 0;
					break;
				case 3:
					MainPro.logs.PrintLogs();
					MainPro.game.PrintFichas();
                                        main.setPanel(new ProyectoVisual.ReportVisual.Reportes());
					//Reportes();
                                        gmenu.bt_gmenu = 0;
					break;
				case 4:
                                        main.setPanel(new Perfil());
					Perfil();
					if(elim){
						elim = false;
						return;
					}
                                        gmenu.bt_gmenu = 0;
					break;
				case 5:
					MainPro.logs.CerrarSes();
                                        main.setPanel(menuIni);
                                        gmenu.bt_gmenu = 0;
					return;
                                case 0:
                                        continue;
				default:
					System.out.println("Error: Comando no valido");
				
			}		
		}while(opcionMainMenu != 5);
	}
	
	public void Configuracion(){
                    if(config.dExperto.isSelected()){
                        dificultad=2;
                    }else if(config.dMaestro.isSelected()){
                        dificultad=3;
                    }else{
                        dificultad=1;
                    }
                    
                    if(config.mAleatorio.isSelected()){
                        modoDeJuegoRandom = true;
                    }else{
                        modoDeJuegoRandom = false;
                    }
                System.out.println(dificultad+","+modoDeJuegoRandom);
                main.setPanel(gmenu);
	}
	
	public void Reportes(int opcion){
		//int opcionReportes = opcion; 	
		//do{						
			//System.out.print("--------------------------\n1-Historial de Juegos\n2-Ranking de Jugadores\n3-Regresar\n-");
			
            switch(opcion){
                    case 1:
                            Historial();
                            break;
                    case 2:
                            Ranking();
                            break;
                    case 3:
                            return;
                    default:
                            System.out.println("Error: Comando no valido");
				
			}		
		//}while(opcionReportes != 5);
	}
	
	public void Perfil(){

		int opcionPerfil; 	
		do{						
			//System.out.print("--------------------------\n1-Ver mis datos\n2-Cambiar Contraseï¿½a\n3-Eliminar mi cuenta\n4-Regresar\n-");
			opcionPerfil = perf.bt_perfil;
			switch(opcionPerfil){
				case 1:
                                        perf.setPanel(new Datosv());
					Datos();
                                        perf.bt_perfil=0;
					break;
				case 2:
					perf.setPanel(new CambiarContra());
                                        //MainPro.logs.CambiarCont();
                                        perf.bt_perfil=0;
					break;
				case 3:
                                        perf.setPanel(new Eliminar());
					MainPro.logs.Elim();
					if(elim){
                                                main.setPanel(menuIni);
						return;
					}
                                        perf.bt_perfil=0;
					break;
				case 4:
                                        main.setPanel(gmenu);
					return;
                                case 0:
                                        continue;
				default:
					System.out.println("Error: Comando no valido");
			}		
		}while(opcionPerfil != 4);
	}
	
	public void Historial(){
		System.out.println("--------------------------\nPROXIMAMENTE");
	}
	
	public void Ranking(){
		System.out.println("--------------------------\nPROXIMAMENTE");
	}
	
	public void Datos(){
		for(int i = 0; i<MainPro.logs.arrUsuarios.length; i++){
			if(MainPro.logs.arrUsuarios[i].logged.equals("main")){
				System.out.println("--------------------------\nTus Datos:\nNombre: " + MainPro.logs.arrUsuarios[i].usuario + 
						"\nPassword: *****\nRank: " + MainPro.logs.arrUsuarios[i].rank);
                                Datosv.nUser.setText(MainPro.logs.arrUsuarios[i].usuario);
                                Datosv.contra.setText("*********");
                                Datosv.rankpos.setText(MainPro.logs.arrUsuarios[i].rank+"");
                        }
		}
	}	
}
