class Character:

    def __init__(self, hp=100, fp=100):
        self.maxHP = hp
        self.maxFP = fp

    def stats(self):
        print(f"Max HitPoints: {self.maxHP}\nMax FocusPoints: {self.maxFP}")


class Hero(Character):

    def __init__(self, hp=150, fp=200, dmg=10):
        Character.__init__(self, hp, fp)
        self.dmg = dmg

    def attack(self):
        print(f"*Swings sword* \nYou did {self.dmg} damage.")


def main():
    mc = Hero()
    mc.stats()
    mc.attack()


if __name__ == "__main__":
    main()
