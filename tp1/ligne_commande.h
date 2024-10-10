#ifndef _LIGNE_COMMANDE_V2_H
#define _LIGNE_COMMANDE_V2_H

/**
 * Cette fonction lit sur l'entrÃ©e standard une ligne de texte,
 * la dÃ©coupe selon les espaces, et retourne un tableau de char*
 * du type attendu par execv et execvp.
 *
 * Si la fin de fichier est rencontrÃ©e, cette fonction retourne NULL.
 *
 * Voir aussi les fonctions fin_de_fichier et ligne_vide.
 */

char** lis_ligne();

/**
 * Cette fonction prend en paramÃ¨tre le tableau de char* retournÃ© par lis_ligne
 * et retourne vrai si et seulement si lis_ligne a rencontrÃ© la fin de fichier.
 * (c.Ã .d. si ligne est NULL)
 */
int fin_de_fichier(char** ligne);

/**
 * Cette fonction prend en paramÃ¨tre le tableau de char* retournÃ© par lis_ligne
 * et retourne vrai si la ligne lue Ã©tait vide.
 * PrÃ©-condition: on n'est pas en fin de fichier, ligne != NULL
 */
int ligne_vide(char** ligne);


/**
 * Cette procÃ©dure coupe une chaÃ®ne de caractÃ¨res en deux Ã  l'endroit du signe
 * Ã©gal, de sorte qu'aprÃ¨s son exÃ©cutuion:
 *  - la chaÃ®ne passÃ©e en paramÃ¨tre ne contient plus que sa partie gauche,
 *  - le pointeur retournÃ© pointe vers la partie droite.
 *
 * Si la chaÃ®ne passÃ©e en paramÃ¨tre ne contient pas le signe Ã©gal, la chaÃ®ne
 * n'est pas modifiÃ©e, et la fonction retourne NULL.
 */
char* separe_egal(char* str);


#endif 
