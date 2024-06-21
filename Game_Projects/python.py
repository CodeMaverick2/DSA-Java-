def echelon_form(matrix, n):
    for i in range(n):
        if matrix[i][i] == 0:
            for j in range(i + 1, n):
                if matrix[j][i] != 0:
                    matrix[i], matrix[j] = matrix[j], matrix[i]
                    break
        for j in range(i + 1, n):
            ratio = matrix[j][i] / matrix[i][i]
            for k in range(n):  
                matrix[j][k] -= ratio * matrix[i][k]
    return matrix
matrix = [[1, 2, 3], 
          [4, 5, 6], 
          [7, 8, 9]]
n = 3
print(echelon_form(matrix, n))