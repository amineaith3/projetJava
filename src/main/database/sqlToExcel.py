import pandas as pd

def execute_sql_file(sql_file):
    with open(sql_file, 'r') as f:
        sql_queries = f.read().split(';')

    dataframes = []
    for query in sql_queries:
        if not query.strip():
            continue
        result = pd.read_sql(query, con=None)
        dataframes.append(result)

    return dataframes

def save_to_excel(dataframes, excel_file):
    writer = pd.ExcelWriter(excel_file, engine='xlsxwriter')

    for i, df in enumerate(dataframes):
        df.to_excel(writer, sheet_name=f'Sheet{i+1}', index=False)

    writer.save()

if __name__ == "__main__":
    sql_file = "base-donne.sql"
    excel_file = "baseDonnee.xlsx"

    dataframes = execute_sql_file(sql_file)

    save_to_excel(dataframes, excel_file)

    print("Excel file successfully created.")
