import csv

import yaml

input_csv = "MOCK_DATA.csv"
output_yaml = "MOCK_DATA.yaml"


def csv_to_yaml(csv_file, yaml_file):
    with open(csv_file, newline="", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        data = []
        for row in reader:
            # Convert numeric fields to appropriate types
            for key in ["id", "portion_weight", "energy", "protein", "carbs", "fat"]:
                if key in row:
                    try:
                        if "." in row[key]:
                            row[key] = float(row[key])
                        else:
                            row[key] = int(row[key])
                    except ValueError:
                        pass
            data.append({"model": "foods.FoodItem", "fields": row})

    with open(yaml_file, "w", encoding="utf-8") as f:
        yaml.dump(data, f, allow_unicode=True, sort_keys=False)


if __name__ == "__main__":
    csv_to_yaml(input_csv, output_yaml)
