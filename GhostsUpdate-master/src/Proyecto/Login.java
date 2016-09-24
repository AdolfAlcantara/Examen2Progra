package Proyecto;
import java.util.Scanner;
import ProyectoVisual.*;
import ProyectoVisual.PerfilVisual.CambiarContra;
import javax.swing.JOptionPane;

public class Login {
	MenuInicial menuIni = new MenuInicial();
        MainMenu main = new MainMenu();
        Scanner scan = new Scanner(System.in);
        CrearUsuario crearUsu = new CrearUsuario();
        CambiarContra cContra = new CambiarContra();
	Usus arrUsuarios[];
	String usuIngr, passIngr, nuevoUsu, nuevoCont, nuevoCont2;
	
	
	public void Array(){
		arrUsuarios = new Usus[5];
		for(int i = 0; i<arrUsuarios.length; i++){
			arrUsuarios[i] = new Usus("null", "null", 0, "no");
		}
		arrUsuarios[0] = new Usus("dego", "dego", 5, "no");
		arrUsuarios[1] = new Usus("ivan", "ivan", 5, "no");
		arrUsuarios[2] = new Usus("raul", "raul", 5, "no");
	}
	
	public boolean Logins(String tipo){
		
                if(tipo.equals("p2")){
                    usuIngr = JOptionPane.showInputDialog(MainPro.main, "Ingresar usuario Player 2", "PLAYER 2", JOptionPane.WARNING_MESSAGE);
                    passIngr = JOptionPane.showInputDialog(MainPro.main, "Ingresar contraseña Player 2", "PLAYER 2", JOptionPane.WARNING_MESSAGE);
                }else{
                usuIngr = menuIni.usuario; 
		passIngr = menuIni.contra; 
                }
		for(Usus i : arrUsuarios){
			if(usuIngr.equals(i.usuario) && passIngr.equals(i.password) && !i.logged.equals("main")){
				i.logged = tipo;
                                if(tipo.equals("main")){
                                    main.setPanel(new GameMenu());}
                                else{
                                }
				return true;
			}
		}
                JOptionPane.showMessageDialog(menuIni, "Usuario o contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);	
                return false;
	}
	
	public void CrearUsu(){
                    System.out.print("--------------------------\nNombre del usuario:\n-");
                    nuevoUsu = crearUsu.usuario;//crearUsu.nuevoUsu.getText();//scan.next();
                    System.out.println(nuevoUsu);
                    for(Usus i : arrUsuarios){
                            if(nuevoUsu.equals(i.usuario)){
                                    JOptionPane.showMessageDialog(menuIni, "Usuario Ocupado.", "Error", JOptionPane.WARNING_MESSAGE);	
                                    break;
                            }
                    }
                    System.out.print("Contrase�a:\n-");
                    nuevoCont = crearUsu.contra; //crearUsu.nuevaContra.getText(); //scan.next();
                    System.out.print("Repita la contrase�a:\n-");
                    nuevoCont2 = crearUsu.contra2; //nuevaContra2.getText(); //scan.next();

                    if(nuevoCont.equals(nuevoCont2)){
                            for(Usus i : arrUsuarios){
                                    if(i.usuario.equals("null")){
                                            i.usuario = nuevoUsu;
                                            i.password = nuevoCont;
                                            JOptionPane.showMessageDialog(menuIni, "Usuario creado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                                            main.setPanel(menuIni);
                                            return;
                                    }
                            }
                            System.out.println("Error: Hay demasiados usuarios");
                            JOptionPane.showMessageDialog(menuIni, "Demasiados Usuarios.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            main.setPanel(menuIni);
                    }
                    else{
                            System.out.println("Las contrase�as no coinciden");
                            JOptionPane.showMessageDialog(menuIni, "Contraseñas no coinciden.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
        }
	public void CerrarSes(){
            //System.out.println(usuIngr+","+passIngr);
		for(Usus i : arrUsuarios){
			if(i.logged.equals("main")){
				i.logged = "no";
			}	
		}
	}
	
	public void Elim(){
		System.out.print("--------------------------\n*ESTA SEGURO QUE DESEA ELIMINAR SU CUENTA?*\n1-Si\n2-No\n-");
		int elimChoice = JOptionPane.showConfirmDialog(main,"Estas seguro que deseas eliminar tu cuenta.","Cuidado",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
		switch(elimChoice){
			case 0:
				for(Usus i : arrUsuarios){
					if(i.logged.equals("main")){
						i.usuario = "null";
						i.password = "null";
						i.rank = 0;
						i.logged = "no";
					}
				}
				MainPro.inicio.elim = true;
			default:
				break;
		}
		
	}
	
	public void CambiarCont(){
		
		System.out.print("--------------------------\nIngrese su vieja contrase�a:\n-");
		passIngr = cContra.vContra; //scan.next();
		
		for(Usus i : arrUsuarios){
			if(i.logged.equals("main") && passIngr.equals(i.password)){
				System.out.print("Ingrese su nueva contrase�a:\n-");
				nuevoCont = cContra.nContra; //scan.next();
				System.out.print("Repita su nueva contrase�a:\n-");
				nuevoCont2 = cContra.nContra2; //scan.next();
				if(nuevoCont.equals(nuevoCont2)){
					i.password = nuevoCont;
					//System.out.println("--------------------------\nContrase�a Cambiada!");
                                        JOptionPane.showMessageDialog(menuIni, "Contraseñas cambiada exitosamente.", "EXITO", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					//System.out.println("--------------------------\nLas nuevas contrase�as no coinciden");
                                        JOptionPane.showMessageDialog(menuIni, "Contraseñas no coinciden.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				return;
			}
		}
		//System.out.println("--------------------------\nContrase�a incorrecta");
                JOptionPane.showMessageDialog(menuIni, "Contraseñas incorrecta.", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	
	public void PrintLogs(){
		for(Usus i : arrUsuarios){
				System.out.println("-usu: \"" + i.usuario + "\" -pass: \"" + i.password + "\" -logd: \"" + i.logged + "\"");
		}
	}
}

