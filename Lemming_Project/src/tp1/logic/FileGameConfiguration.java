package tp1.logic;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;
import tp1.exceptions.*;
import java.io.*;


public class FileGameConfiguration implements GameConfiguration   {
    private int cycle;
    private int numLemmingsInBoard;
    private int numLemmingsDead;
    private int numLemmingsExit;
    private int numLemmingsToWin;
    private GameObjectContainer gameObjects;
    private String fileName;
    public static final GameConfiguration NONE = new FileGameConfiguration();

    public FileGameConfiguration(){
        this.fileName = null;
    }
    @SuppressWarnings("resource")
	public FileGameConfiguration(String fileName,GameWorld game) throws GameLoadException {
        
        //abrimos el fichero
        this.fileName = fileName;
        gameObjects = new GameObjectContainer(game);
        try{
            File ficheroEntrada= new File(fileName);
            FileReader entrada = new FileReader(ficheroEntrada);
            BufferedReader config = new BufferedReader(entrada);
            //ahora vamos leyendo el fichero linea a linea para ir rellenando los atributos
            String line = config.readLine();
            //Parseamos la primera linea que tiene la info genereal del juego
            String[] info = line.trim().split("\\s+");
            if (info.length != 5) {
            	throw new GameLoadException(Messages.INVALID_GAME_STATUS.formatted(line));
            }
            this.cycle = Integer.parseInt(info[0]);
            this.numLemmingsInBoard = Integer.parseInt(info[1]);
            this.numLemmingsDead = Integer.parseInt(info[2]);
            this.numLemmingsExit = Integer.parseInt(info[3]);
            this.numLemmingsToWin = Integer.parseInt(info[4]);
            //ahora parseamos el resto de lineas que tienen los objetos
            
            while((line = config.readLine()) != null){
                try{
                   
                    GameObject obj = GameObjectFactory.parse(line, game);
                    gameObjects.add(obj);
                }catch(ObjectParseException e){
                    config.close();
                    throw new GameLoadException(e.getMessage().formatted(line));
                }catch(OffBoardException e){
                    config.close();
                    throw new GameLoadException(e.getMessage().formatted(line));
                }
                
            }
            //cerramos fichero
            config.close();

        }catch(FileNotFoundException e){
            throw new GameLoadException(Messages.FILE_NOT_FOUND.formatted(fileName));
        }
        catch(IOException e){
            throw new GameLoadException(Messages.READ_ERROR.formatted(fileName));
        }
        catch(NumberFormatException e){
            throw new GameLoadException("Error al parsear el fichero");
        }


    }
    @Override
    public boolean equals(Object o) {
        FileGameConfiguration f = (FileGameConfiguration) o;
        if(this.fileName==null && f.fileName==null){
            return true;
        }else if(this.fileName==null || f.fileName==null){
            return false;
        }else {
            return this.fileName.equals(f.fileName);
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
        return this.gameObjects.copy();
    }
    public String getFileName(){
        return this.fileName;
    }
    


}