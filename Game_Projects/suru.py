def gauss_jordan_elimination(matrix):
    n = len(matrix)
    for i in range(n):
        pivot = matrix[i][i]
        for j in range(n+1):
            matrix[i][j] /= pivot
        for k in range(n):
            factor = matrix[k][i]
            if k!=i:
                for j in range(n+1):
                    matrix[k][j] -= factor*matrix[i][j]
    solution = [row[n] for row in matrix]
    return solution
    

augmented_matrix = [
    [1, 1, -1, 7],
    [1, -1, 2, 3],
    [2 ,1 ,1 , 9]
]

solution = gauss_jordan_elimination(augmented_matrix)

print("Solution:")
for i, val in enumerate(solution):
    print(f"x{i+1} = {val}")

