# store
	
	echo "# store" >> README.md
	git init
	git add README.md
	git commit -m "first commit"
	git branch -M main
	git remote add origin https://github.com/sangbinlee/store.git
	git push -u origin main
	
	
	
# 	jdbc:mysql://localhost:3306/test_db?useSSL=false&allowPublicKeyRetrieval=true
	mysql> create database db_example2; -- Creates the new database
	mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
	mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database