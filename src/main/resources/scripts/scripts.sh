#Get and extract elastic search
curl -L -O https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.9.3-linux-x86_64.tar.gz
tar -xvf elasticsearch-7.9.3-linux-x86_64.tar.gz elasticsearch-7.9.3/

wget http://media.sundog-soft.com/es7/movies.json

wget http://media.sundog-soft.com/es7/shakes-mapping.json
wget http://media.sundog-soft.com/es7/shakespeare_7.0.json



# Get full movie lens dataset
wget http://files.grouplens.org/datasets/movielens/ml-latest-small.zip



# Get python script movies to json
wget http://media.sundog-soft.com/es7/MoviesToJson.py
wget http://media.sundog-soft.com/es7/IndexRatings.py

# Get access log
wget http://media.sundog-soft.com/es/access_log
