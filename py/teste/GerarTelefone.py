import random
import math
def telefone():
    n = [random.randrange(10) for i in range(8)] 
    return "119%d%d%d%d%d%d%d%d" % tuple(n)