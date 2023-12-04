# Gera arquivos .txt de teste para o problema da mochila no seguinte formato:
# Primeira linha: número de itens
# Segunda linha: tamanho da mochila
# Linhas seguintes: número do item, peso do item, valor do item

import random

def generate_test_case(n, max_weight, max_value):
    test_case = []
    for i in range(1, n+1):
        backpackSize = random.randint(1, max_weight*5)
        weight = random.randint(1, max_weight)
        value = random.randint(1, max_value)
        test_case.append((i, weight, value))
    return test_case

def save_test_case(max_weight,file_name, test_case):
    backpackSize = random.randint(1, max_weight*5)
    with open(file_name, 'w') as file:
        file.write(f"{number_of_items}\n")
        file.write(f"{backpackSize}\n")
        for item in test_case:
            file.write(f"{item[0]} {item[1]} {item[2]}\n")

# Example usage:
number_of_items = 15
max_item_weight = 20
max_item_value = 20

nomeArq = 'Testes/teste' + str(number_of_items) + '.txt'
test_case = generate_test_case(number_of_items, max_item_weight, max_item_value)
save_test_case(max_item_weight, nomeArq, test_case)
