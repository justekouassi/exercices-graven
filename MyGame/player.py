import pygame
from projectile import Projectile

# créer une classe pour le joueur


class Player(pygame.sprite.Sprite):
    def __init__(self, game):
        super().__init__()
        self.game = game
        self.health = 100
        self.max_health = 100
        self.attack = 10
        self.velocity = 5
        self.image = pygame.image.load("assets/player.png")
        self.rect = self.image.get_rect()
        self.rect.x = 400
        self.rect.y = 400
        self.all_projectiles = pygame.sprite.Group()

    def damage(self, amount):
        if self.health - amount > amount:
            self.health -= amount
        else:
            self.game.game_over()

    def update_health_bar(self, surface):
        # dessiner la jauge
        # surface, bar_color, bar_position
        pygame.draw.rect(surface, (60, 63, 60), [
                         self.rect.x + 50, self.rect.y + 20, self.max_health, 5])
        pygame.draw.rect(surface, (111, 210, 46), [
                         self.rect.x + 50, self.rect.y + 20, self.health, 5])

    def launch_projectile(self):
        # créer une instance de la classe projectile
        self.all_projectiles.add(Projectile(self))

    def move_right(self):
        if not self.game.check_collision(self, self.game.all_monsters):
            self.rect.x += self.velocity

    def move_left(self):
        self.rect.x -= self.velocity
