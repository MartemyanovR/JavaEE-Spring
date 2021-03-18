package ru.mart.springInit.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.mart.springInit.model.Client;


@RestController
@RequestMapping("store/clients")
public class ClientRestController {
	private List<Client> listClients = Stream.of(
			new Client(1L, "Roman", "1@mail.ru"),
			new Client(2L, "Stepan", "Step@mail.ru"),
			new Client(3L, "Egor", "gor@mail.ru")
			).collect(Collectors.toList());

	@GetMapping
	public List<Client> getAll() {
		return listClients;
	}
	
	@GetMapping("/{id}")
	public Client getById(@PathVariable Long id) {
		return listClients.stream().filter(client->client.getId().equals(id)).findFirst().orElse(null);
	}
	
	/**
	 * Добавление нового клиента в наш лист пользователей
	 * @param client новый пользователь, который принимается из тела запроса(@RequestBody)
	 * @return нового пользователя 
	 */
	@PostMapping
	public Client create(@RequestBody Client client) {
		this.listClients.add(client);
		return client;
	}
	
	/**
	 * Удаление клиента
	 * @param id идентификатор клиента
	 */
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		this.listClients.removeIf(client->client.getId().equals(id));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
