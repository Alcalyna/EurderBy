package org.calinh.eurderbylinh.api;

import org.calinh.eurderbylinh.domain.user.Feature;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.CreateItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.ItemDto;
import org.calinh.eurderbylinh.model.dtos.itemsdtos.UpdateItemDto;
import org.calinh.eurderbylinh.model.services.ItemService;
import org.calinh.eurderbylinh.model.services.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "items")
public class ItemController {

    private ItemService itemService;
    private SecurityService securityService;

    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto newItem, @RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.ADD_ITEM);
        return itemService.addItem(newItem);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems(@RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.DISPLAY_ITEMS);
        return itemService.getAllItemsReposository();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItem(@RequestBody UpdateItemDto updateItemDto, @RequestHeader String authorization) {
        securityService.validateAccess(authorization, Feature.UPDATE_ITEM);
        System.out.println(updateItemDto);
        return itemService.updateItem(updateItemDto);
    }
}
