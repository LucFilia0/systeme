package agregateurcommentaires;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 *
 * @author remi
 */
public class CommentGenerator {
    
    protected static List<String> listComments;
    
    static {
        listComments = new ArrayList<String>();
        listComments.add("But des locaux !!!");
        listComments.add("But des visiteurs !!!");
        listComments.add("Touche en faveur des locaux");
        listComments.add("Touche en faveur des visiteurs");
        listComments.add("Hors-jeu des locaux");
        listComments.add("Hors-jeu des visiteurs");
        listComments.add("Coup-franc des locaux");
        listComments.add("Coup-franc des visiteurs");
        listComments.add("Pénalty pour les locaux");
        listComments.add("Pénalty pour les visiteurs");
        listComments.add("Remplacement d'un joueur local");
        listComments.add("Remplacement d'un joueur visiteur");
        listComments.add("6 mètres pour les locaux");
        listComments.add("6 mètres pour les visiteurs");
        listComments.add("Belle occasion pour les locaux !");
        listComments.add("Belle occasion pour les visiteurs !");
        listComments.add("Faute des locaux");
        listComments.add("Faute des visiteurs");
        listComments.add("Envahissement du terrain par des supporters !");
    }
    
    public static String getRandomComment() {
        int a = (int)Math.round((Math.random()*100))%CommentGenerator.listComments.size();
        System.out.println(a);
        return CommentGenerator.listComments.get(a);
    }
    
}
