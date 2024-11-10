public class Main {

    public static void main(String[] args) {

        int NUMERO_POKEMONS_A_DESCARGAR = 10;

        PokeDownloaderManager pokeDownloader = new PokeDownloaderManager(4);
        try{
            pokeDownloader.getNImages(NUMERO_POKEMONS_A_DESCARGAR);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}


