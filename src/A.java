public class A implements Runnable {

    private String name;
    private Integer counter;
    A (String name) {
        this.name = name;
        this.counter = 0;
    }

    @Override
    public void run() {
        //whatever
        while (true) {
/*            System.out.print(this.counter++);
            System.out.print(" ");
            System.out.println(this.name);*/

            String msg = this.counter++ + " " + this.name;

            System.out.println(msg);

            double rnd = Math.random() * 1000;

            int time = 1000 + (int)(rnd);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
