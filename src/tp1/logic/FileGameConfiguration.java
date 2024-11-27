package tp1.logic;
import tp1.logic.gameobjects.*;
import tp1.exceptions.*;
import java.io.*;


public class FileGameConfiguration implements GameConfiguration   {
    private int cycle;
    private int numLemmingsInBoard;
    private int numLemmingsDead;
    private int numLemmingsExit;
    private int numLemmingsToWin;
    private GameObjectContainer gameObjects;

    public FileGameConfiguration(String fileName,GameWorld game) throws GameLoadException, IOException, ObjectParseException, OffBoardException {
        
        //abrimos el fichero
        
        try{
            File ficheroEntrada= new File(fileName);
            FileReader entrada = new FileReader(ficheroEntrada);
            BufferedReader config = new BufferedReader(entrada);
            //ahora vamos leyendo el fichero linea a linea para ir rellenando los atributos
            String line = config.readLine();
            //Parseamos la primera linea que tiene la info genereal del juego
            String[] info = line.trim().split("\\s+");
            this.cycle = Integer.parseInt(info[0]);
            this.numLemmingsInBoard = Integer.parseInt(info[1]);
            this.numLemmingsDead = Integer.parseInt(info[2]);
            this.numLemmingsExit = Integer.parseInt(info[3]);
            this.numLemmingsToWin = Integer.parseInt(info[4]);
            //ahora parseamos el resto de lineas que tienen los objetos
            GameObject obj = null;
            while((line = config.readLine()) != null){
                try{
                    obj = GameObjectFactory.parse(line, game);
                }catch(ObjectParseException e){
                    throw new GameLoadException("Error al parsear el objeto");
                }
                gameObjects.add(obj);
            }
            //cerramos fichero
            config.close();

        }catch(FileNotFoundException e){
            throw new GameLoadException("Error al abrir el fichero");
        }
        catch(IOException e){
            throw new GameLoadException("Error al leer el fichero");
        }
        catch(NumberFormatException e){
            throw new GameLoadException("Error al parsear el fichero");
        }


    }

    @Override
    public int getCycle() {
        // TODO Auto-generated method stub
        return this.cycle;
    }

    @Override
    public int numLemmingsInBoard() {
        // TODO Auto-generated method stub
        return this.numLemmingsInBoard;
    }

    @Override
    public int numLemmingsDead() {
        // TODO Auto-generated method stub
        return this.numLemmingsDead;
    }

    @Override
    public int numLemmingsExit() {
        // TODO Auto-generated method stub
        return this.numLemmingsExit;
    }

    @Override
    public int numLemmingsToWin() {
        // TODO Auto-generated method stub
        return this.numLemmingsToWin;
    }

    @Override
    public GameObjectContainer getGameObjects() {
        // TODO Auto-generated method stub
        return this.gameObjects;
    }

    


}
