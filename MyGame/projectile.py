import pygame

# définir la classe du projectile


class Projectile(pygame.sprite.Sprite):
    def __init__(self, player):
        super().__init__()
        self.velocity = 5
        self.player = player
        self.image = pygame.image.load("assets/projectile.png")
        self.image = pygame.transform.scale(self.image, (50, 50))
        self.rect = self.image.get_rect()
        self.rect.x = player.rect.x + 120
        self.rect.y = player.rect.y + 80
        self.origin_image = self.image
        self.angle = 0

    def rotate(self):
        # tourner le projectile
        self.angle += 5
        self.image = pygame.transform.rotozoom(
            self.origin_image, self.angle, 1)
        self.rect = self.image.get_rect(center=self.rect.center)

    def remove(self):
        self.player.all_projectiles.remove(self)

    def move(self):
        self.rotate()
        self.rect.x += self.velocity
        for monster in self.player.game.check_collision(self, self.player.game.all_monsters):
            self.remove()
            # infliger des dégats aus monstres
            monster.damage(self.player.attack)

        # vérfier si notre projectile n'est plus présent sur l'écran
        if self.rect.x > 1080:
            # supprimer le projectile en dehors de l'écran
            self.remove()
