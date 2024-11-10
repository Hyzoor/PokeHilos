import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PokeImageDownloader extends Thread{

    private String url;
    private BufferedImage pokeSprite;

    @Override
    public void run() {
        pokeSprite = downloadImg(url);

    }

    public BufferedImage downloadImg(String imgURL) {
        URL spriteUrl;
        BufferedImage pokeSprite;
        try {
            spriteUrl = new URL(imgURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            pokeSprite = ImageIO.read(spriteUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.err.println("DESCARGAO: " + imgURL);

        return pokeSprite;
    }

    public void setSource(String urlSource){
        url = urlSource;
    }

    public BufferedImage getPokeSprite(){
        return pokeSprite;
    }
}
