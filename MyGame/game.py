import pygame
from player import Player
from monster import Monster

# créer une classe pour le jeu


class Game:
    def __init__(self):
        # définir si le jeu a débuté ou non
        self.is_playing = False

        # générer le joueur
        self.all_players = pygame.sprite.Group()
        self.player = Player(self)
        self.all_players.add(self.player)
        # groupe de monstres
        self.all_monsters = pygame.sprite.Group()
        self.pressed = {}

    def start(self):
        self.is_playing = True
        self.spawn_monster()
        self.spawn_monster()

    def game_over(self):
        self.all_monsters = pygame.sprite.Group()
        self.player.health = self.player.max_health
        self.is_playing = False

    def update(self, screen):
        # appliquer l'image du joueur
        screen.blit(self.player.image, self.player.rect)

        # actualiser la barre de vie du joueur
        self.player.update_health_bar(screen)

        # récupérer les projectiles du joueur
        for projectile in self.player.all_projectiles:
            projectile.move()

        # récupérer les monstres de notre jeu
        for monster in self.all_monsters:
            monster.forward()
            monster.update_health_bar(screen)

        # appliquer l'ensemble des images du groupe projectile
        self.player.all_projectiles.draw(screen)

        # appliquer l'ensemble des images du groupe de monstres
        self.all_monsters.draw(screen)

        # vérifier la direction du joueur
        if self.pressed.get(pygame.K_RIGHT) and self.player.rect.x < 910:
            self.player.move_right()
        elif self.pressed.get(pygame.K_LEFT) and self.player.rect.x > -30:
            self.player.move_left()

    def check_collision(self, sprite, group):
        return pygame.sprite.spritecollide(sprite, group, False, pygame.sprite.collide_mask)

    def spawn_monster(self):
        monster = Monster(self)
        self.all_monsters.add(monster)
