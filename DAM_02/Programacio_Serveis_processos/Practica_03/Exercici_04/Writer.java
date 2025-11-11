package Exercici_04;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Writer implements Runnable {

    private final String name;
    private final List<Article> articles;
    private final int writesToDo;

    public Writer(String name, List<Article> articles, int writesToDo) {
        this.name = name;
        this.articles = articles;
        this.writesToDo = writesToDo;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < writesToDo; i++) {
                Article article = articles.get(
                        ThreadLocalRandom.current().nextInt(articles.size())
                );

                String newContent = "Contingut nou #" + (i + 1) + " per " + article.getTitle() +
                        " (escriptor: " + name + ")";

                article.write(name, newContent);

                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
            }
            System.out.println("[" + name + "] Ha acabat d'escriure.");
        } catch (InterruptedException e) {
            System.out.println("[" + name + "] interromput mentre escrivia.");
            Thread.currentThread().interrupt();
        }
    }
}
