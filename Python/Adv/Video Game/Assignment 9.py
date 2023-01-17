from numpy import true_divide
import pygame
import random
pygame.font.init()

WIDTH, HEIGHT = 1280, 720
WIN = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Assignment 9")

WHITE = (255, 255, 255)

FPS = 60

MAX_UFOS = 15
MAX_ALLIES = 4

UFO_HEIGHT, UFO_WIDTH = 80, 60
SHIP_HEIGHT, SHIP_WIDTH = 100, 90

UFO_IMAGE = pygame.image.load('UFO.png')
UFO = pygame.transform.scale(UFO_IMAGE, (UFO_HEIGHT, UFO_WIDTH))

ROCKET_IMAGE = pygame.image.load('Rocket.png')
ROCKET = pygame.transform.rotate(
    pygame.transform.scale(ROCKET_IMAGE, (SHIP_HEIGHT, SHIP_WIDTH)), 90)

STARS = pygame.image.load('Stars.jpg')

TEXT_FONT = pygame.font.SysFont('comicsans', 40)
HEALTH = 3
HIGH_SCORE = 0
SCORE = 0

Y1 = [15, 105, 190, 280]
Y2 = [0, 85, 170, 260]
POS_X = WIDTH
UFO_POS_Y = random.choice(Y1)
SHIP_POS_Y = random.choice(Y2)
MOVE_SPEED = 4

yTemp1 = 0
yTemp2 = 0
def draw_window(UFO_amount, allies):
    global HEALTH, SCORE
    WIN.blit(STARS, (0,0))
    data()

    for enemy in UFO_amount:
        enemy.x -= MOVE_SPEED
        if enemy.x <= 0:
            UFO_amount.remove(enemy)
            HEALTH -= 1
        WIN.blit(UFO, (enemy.x, enemy.y))

    for ally in allies:
        ally.x -= MOVE_SPEED
        if ally.x <= 0:
            allies.remove(ally)
        WIN.blit(ROCKET, (ally.x, ally.y))

    pygame.display.update()
    
def make_UFO(UFO_amount):
    global UFO_POS_Y, yTemp1
    POS_X = WIDTH
    POS_X += random.randrange(100, 1000)
    while yTemp1 == UFO_POS_Y:
        UFO_POS_Y = random.choice(Y1)
    yTemp1 = UFO_POS_Y

    enemy = pygame.Rect(
        POS_X, UFO_POS_Y, UFO_WIDTH, UFO_HEIGHT)
    UFO_amount.append(enemy)

def make_ally(ally_amount):
    global SHIP_POS_Y, yTemp2
    POS_X = WIDTH
    POS_X += random.randrange(100, 1000)
    while yTemp2 == SHIP_POS_Y:
        SHIP_POS_Y = random.choice(Y2)
    yTemp2 = SHIP_POS_Y

    ally = pygame.Rect(
        POS_X, SHIP_POS_Y, SHIP_WIDTH, SHIP_HEIGHT)
    ally_amount.append(ally)

def data():
    health_text = TEXT_FONT.render(
        "Health: " + str(HEALTH), 1, WHITE)
    WIN.blit(health_text, (540, 350))

    score_text = TEXT_FONT.render(
        "Score: " + str(SCORE), 1, WHITE)
    WIN.blit(score_text, (540, 400))

    high_score_text = TEXT_FONT.render(
        "High Score: " + str(HIGH_SCORE), 1, WHITE)
    WIN.blit(high_score_text, (0, 670))

    move_speed_text = TEXT_FONT.render(
        "Move Speed: " + str(MOVE_SPEED), 1, WHITE)
    WIN.blit(move_speed_text, (980, 670))

    ufo_amount_text = TEXT_FONT.render(
        "UFOS: " + str(MAX_UFOS), 1, WHITE)
    WIN.blit(ufo_amount_text, (1090, 630))

def pause():
    global MOVE_SPEED, MAX_UFOS, HEALTH
    paused = True
    
    while paused:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    paused = False
                if event.key == pygame.K_r:
                    MOVE_SPEED = 3
                    MAX_UFOS = 15
                    HEALTH = 3
                
        pause = TEXT_FONT.render("Paused!", 1, WHITE)
        WIN.blit(pause, (550, 500))
        pygame.display.update()

def game_over():
    global SCORE, HIGH_SCORE
    WIN.blit(STARS, (0,0))
    if SCORE > HIGH_SCORE:
        HIGH_SCORE = SCORE

    data()

    draw_text = TEXT_FONT.render("GAME OVER!", 1, WHITE)
    WIN.blit(draw_text, (500, 500))
    
    pygame.display.update()
    pygame.time.delay(2000)

def main():
    global HEALTH, SCORE, HIGH_SCORE, MOVE_SPEED, MAX_UFOS
    UFO_amount = []
    ally_amount = []

    clock = pygame.time.Clock()
    run = True
    while run:
        clock.tick(FPS)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                pygame.quit()

            if event.type == pygame.MOUSEBUTTONDOWN:
                pos = pygame.mouse.get_pos()
                for enemy in UFO_amount:
                    if enemy.collidepoint(pos):
                        UFO_amount.remove(enemy)
                        SCORE += 1
                for ally in ally_amount:
                    if ally.collidepoint(pos):
                        ally_amount.remove(ally)
                        HEALTH -= 1
            
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    MAX_UFOS += 1
                if event.key == pygame.K_DOWN:
                    if MAX_UFOS > 1:
                        MAX_UFOS -= 1
                if event.key == pygame.K_LEFT:
                    if MOVE_SPEED > 1:
                        MOVE_SPEED -= 1
                if event.key == pygame.K_RIGHT:
                    MOVE_SPEED += 1
                if event.key == pygame.K_SPACE:
                    pause()
                if event.key == pygame.K_f:
                    HEALTH += 1
                if event.key == pygame.K_r:
                    MOVE_SPEED = 3
                    MAX_UFOS = 15
                    HEALTH = 3
        
        if HEALTH <= 0:
            game_over()
            break

        while len(UFO_amount) < MAX_UFOS:
            make_UFO(UFO_amount)
        while len(ally_amount) < MAX_ALLIES:
            make_ally(ally_amount)
        draw_window(UFO_amount, ally_amount)
    
    HEALTH = 3
    SCORE = 0
    main()

if __name__ == "__main__":
    main()