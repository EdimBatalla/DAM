package Exercici_04;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Reader implements Runnable {

    private final String name;
    private final List<Article> articles;
    private final int readsToDo;

    public Reader(String name, List<Article> articles, int readsToDo) {
        this.name = name;
        this.articles = articles;
        this.readsToDo = readsToDo;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < readsToDo; i++) {
                // Escollim un article aleatori
                Article article = articles.get(
                        ThreadLocalRandom.current().nextInt(articles.size())
                );

                article.read(name);

                // Fem una pausa entre lectures
                Thread.sleep(ThreadLocalRandom.current().nextInt(200, 700));
            }
            System.out.println("[" + name + "] Ha acabat de llegir.");
        } catch (InterruptedException e) {
            System.out.println("[" + name + "] interromput mentre llegia.");
            Thread.currentThread().interrupt();
        }
    }
}
