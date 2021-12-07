package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.calinh.eurderbylinh.model.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto newItem) {
        return itemService.addItem(newItem);
    }
}
