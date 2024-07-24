import pygame
import math
from game import Game
pygame.init()

# générer la fenêtre du jeu
pygame.display.set_caption("Alien Shooter")
screen = pygame.display.set_mode((1080, 650))  # largeur, hauteur

# arrière-plan du jeu
background = pygame.image.load("assets/bg.jpg")

# importer la bannière
banner = pygame.image.load("assets/banner.png")
banner = pygame.transform.scale(banner, (500, 500))
banner_rect = banner.get_rect()
banner_rect.x = math.ceil(screen.get_width() / 4)

# importer le bouton pour lancer la partie
play_button = pygame.image.load("assets/button.png")
play_button = pygame.transform.scale(play_button, (400, 150))
play_button_rect = play_button.get_rect()
play_button_rect.x = math.ceil(screen.get_width() / 3.33)
play_button_rect.y = 360  # math.ceil(screen.get_height() / 2)

# charger notre jeu
game = Game()

# BOUCLE
running = True

while running:

    # appliquer l'arrière-plan du jeu
    screen.blit(background, (0, -300))

    # vérifier si le jeu a débuté
    if game.is_playing:
        # déclencher les instructions de la partie
        game.update(screen)
    else:
        screen.blit(play_button, play_button_rect)
        screen.blit(banner, banner_rect)

    # mettre à jour l'écran
    pygame.display.flip()

    for event in pygame.event.get():
        # fermeture de la fenêtre
        if event.type == pygame.QUIT:
            running = False
            pygame.quit()
        # détecter le joueur lache une touche du clavier
        elif event.type == pygame.KEYDOWN:
            game.pressed[event.key] = True

            # détecter si la touche espace est enclenchée
            if event.key == pygame.K_SPACE:
                game.player.launch_projectile()

        elif event.type == pygame.KEYUP:
            game.pressed[event.key] = False

        elif event.type == pygame.MOUSEBUTTONDOWN:
            if play_button_rect.collidepoint(event.pos):
                game.start()

"""déplacement du joueur
if event.key == pygame.K_RIGHT:
	game.player.move_right()
elif event.key == pygame.K_LEFT:
	game.player.move_left()
"""
