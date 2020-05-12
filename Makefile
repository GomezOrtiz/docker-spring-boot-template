up:
		@docker-compose up -d

logs:
		@docker-compose logs -f app

down:
		@docker-compose down

status:
		@docker ps -a

cleanup:
		@docker rmi $$(docker images -f "dangling=true" -q)

test:
		@./gradlew test --warning-mode all

ping-db:
		@docker exec template-app-postgres pg_isready --dbname=templatedb --host=localhost --port=5432 --username=templateapp

.PHONY: up logs down status cleanup test ping-db