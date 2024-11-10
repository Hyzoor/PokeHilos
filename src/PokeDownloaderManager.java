import javax.swing.*;
import java.awt.*;
import java.lang.Thread;

public class PokeDownloaderManager {

    private final Window frame;
    private PokeImageDownloader[] downloaders;
    private final int MAX_PARALLEL_DOWNLOADS;
    private final String pokeUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
    private int imageCounter = 1;


    public PokeDownloaderManager(int MAX_PARALLEL_DOWNLOADS){
        this.MAX_PARALLEL_DOWNLOADS = MAX_PARALLEL_DOWNLOADS;
        downloaders = new PokeImageDownloader[MAX_PARALLEL_DOWNLOADS];
        frame = new Window();
    }


    public void getNImages(int n) throws InterruptedException {
        int layout = (int) Math.sqrt(n) + 1;
        frame.setLayout(new GridLayout(layout, layout));
        while(n > 0){

            initializeThreads();

            for(int i = 0; i < MAX_PARALLEL_DOWNLOADS;i ++){
                downloaders[i].setSource(pokeUrl+n+".png");
                n--;
            }

            downloaders[0].start();
            downloaders[1].start();
            downloaders[2].start();
            downloaders[3].start();


            downloaders[0].join();
            downloaders[1].join();
            downloaders[2].join();
            downloaders[3].join();

            for(int i = 0; i < MAX_PARALLEL_DOWNLOADS; i++){
                frame.addImage(downloaders[i].getPokeSprite());
            }

        }
    }


    private void initializeThreads(){
        for(int i = 0; i < MAX_PARALLEL_DOWNLOADS; i++){
            downloaders[i] = new PokeImageDownloader();
        }
    }

}
