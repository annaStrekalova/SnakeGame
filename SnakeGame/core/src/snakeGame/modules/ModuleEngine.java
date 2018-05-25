/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeGame.modules;

import com.mygdx.game.GamePanel;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Anna
 */
public class ModuleEngine {
    public static void main(String args[], GamePanel gp) {
        JFileChooser fileopen = new JFileChooser("C:\\SnakeGameMod\\SnakeGame\\core\\build\\classes\\main\\com\\mygdx\\game\\");
        int ret = fileopen.showDialog(null, "Загрузить");
        String moduleName = null;
        String modulePath = null;
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            moduleName = file.getName().split(".class")[0];
            modulePath = (String)file.getPath();
        }
        ModuleLoader loader = new ModuleLoader(modulePath, ClassLoader.getSystemClassLoader());
        try {
            if (moduleName.equals("Module") == false) {
                System.out.print("Executing loading module: ");
                System.out.println(moduleName);

                Class c = loader.loadClass("com.mygdx.game."+moduleName);
                Module execute = (Module) c.newInstance();

                execute.load(gp,execute);
                execute.unload();
            }
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (InstantiationException e) {
            e.printStackTrace();
        } 
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
