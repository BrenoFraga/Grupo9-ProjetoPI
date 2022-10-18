# Python3 code to demonstrate working of
# Random K dates in Range
# Using randrange() + timedelta() + loop
from datetime import date, timedelta,datetime
import random

def diaCampanha():
    # initializing dates ranges 
    test_date1, test_date2 = date(2022, 9, 20), date(2022, 10, 20)
  
    # initializing K
    K = 1  
    # getting days between dates
    dates_bet = test_date2 - test_date1
    total_days = dates_bet.days
  
    res = []
    for idx in range(K):
        random.seed(a=None)
      
        # getting random days
        randay = random.randrange(total_days)
      
        # getting random dates 
        res.append(test_date1 + timedelta(days=randay))
  
    return datetime.strftime(res[0],'%Y%m%d')

def diaAniversario():
    # initializing dates ranges 
    test_date1, test_date2 = date(2022, 1, 1), date(2022, 7, 31)
  
    # initializing K
    K = 1  
    # getting days between dates
    dates_bet = test_date2 - test_date1
    total_days = dates_bet.days
  
    res = []
    for idx in range(K):
        random.seed(a=None)
      
        # getting random days
        randay = random.randrange(total_days)
      
        # getting random dates 
        res.append(test_date1 + timedelta(days=randay))
  
    return datetime.strftime(res[0],'%Y%m%d')

def diaDoacao(mes, dia):
    if(mes==12):
        proximoMes=1
        anoDepois=2023
    else:
        proximoMes=mes+1
        anoDepois=2022
    if(dia==31):
        proximoMes=mes+1
        dia=1
    # initializing dates ranges 
    test_date1, test_date2 = date(2022, mes, dia), date(anoDepois, proximoMes, dia)
  
    # initializing K
    K = 1  
    # getting days between dates
    dates_bet = test_date2 - test_date1
    total_days = dates_bet.days
  
    res = []
    for idx in range(K):
        random.seed(a=None)
      
        # getting random days
        randay = random.randrange(total_days)
      
        # getting random dates 
        res.append(test_date1 + timedelta(days=randay))
  
    return datetime.strftime(res[0],'%Y%m%d')

def diaCriacao():
    # initializing dates ranges 
    test_date1, test_date2 = date(2022, 9, 20), date(2022, 10, 20)
  
    # initializing K
    K = 1  
    # getting days between dates
    dates_bet = test_date2 - test_date1
    total_days = dates_bet.days
  
    res = []
    for idx in range(K):
        random.seed(a=None)
      
        # getting random days
        randay = random.randrange(total_days)
      
        # getting random dates 
        res.append(test_date1 + timedelta(days=randay))
  
    return datetime.strftime(res[0],'%Y%m%d')