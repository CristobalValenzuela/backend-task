docker-build:
	docker build -t backend-task-image .

docker-up:
	docker run --name backend-task -p 8080:8080 --link mysql-db:mysql -d backend-task-image

docker-down:
	docker rm -f backend-task

docker-restart:
	make docker-down
	make docker-up