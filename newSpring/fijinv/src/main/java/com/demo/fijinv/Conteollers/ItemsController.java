package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Exceptions.ResourceNotFoundException;
import com.demo.fijinv.Models.Image;
import com.demo.fijinv.Models.Items;
import com.demo.fijinv.Models.Logs;
import com.demo.fijinv.Repositories.ImageRepository;
import com.demo.fijinv.Repositories.ItemsRepository;
import com.demo.fijinv.Repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController

@RequestMapping("/api/items")
public class ItemsController {

    @Autowired
    public ItemsRepository itemsRepository;
    @Autowired
    public LogRepository logRepository;

    @Autowired
    public ImageRepository imageRepository;

    @GetMapping
    public List<Items> getAllItems (){
        return itemsRepository.findAll();
    }

//    build create new item
    @PostMapping
    public Items createItem(@RequestBody Items item, Principal principal, Logs logs){
        item.setUser_added_item("default User");
        logs.setLogText(item.getUser_added_item()+ " added new item in " + item.getPlant() + " - " + item.getItemname() + " " + item.getItembrand() + " - "
                + item.getItemmodel() + " is " + item.getIsDamaged() + " which places in " + item.getLocation() + " identified by " + item.getHostname() + " or "
                + item.getIp_address() + " is using by " + item.getUser_name() + " " + item.getOperator_number() + " working in " + item.getDepartment() + " department");
        item.addLogToInvItem(logs);

        return itemsRepository.save(item);
    }

//    buil get item by itemname Rest API
    @GetMapping("{id}")
    public ResponseEntity<Items> getItemByItemname(@PathVariable Long id){
        Items item =  itemsRepository.findById(id).orElseThrow(()->{
            throw new ResourceNotFoundException("Item with such id doesn't exists"+id);
        });
        return ResponseEntity.ok(item);
    }

//    Update Item Rest API Method
    @PutMapping("{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestBody Items itemDetails, Principal principal, Logs logs){

        Items updatedItem = itemsRepository.findById(id).orElseThrow(()->{
            throw new ResourceNotFoundException("Item with such id didn't find : "+id);
        });

        updatedItem.setPlant(itemDetails.getPlant());
        updatedItem.setFaenumber(itemDetails.getFaenumber());
        updatedItem.setSisnumber(itemDetails.getSisnumber());
        updatedItem.setSerialnumber(itemDetails.getSerialnumber());
        updatedItem.setItemname(itemDetails.getItemname());
        updatedItem.setItembrand(itemDetails.getItembrand());
        updatedItem.setItemmodel(itemDetails.getItemmodel());
        updatedItem.setLocation(itemDetails.getLocation());
        updatedItem.setIp_address(itemDetails.getIp_address());
        updatedItem.setHostname(itemDetails.getHostname());
        updatedItem.setIsDamaged(itemDetails.getIsDamaged());
        updatedItem.setUser_name(itemDetails.getUser_name());
        updatedItem.setDepartment(itemDetails.getDepartment());
        updatedItem.setOperator_number(itemDetails.getOperator_number());
        updatedItem.setUser_added_item("default User");

        Logs logs1;
        logs.setLogText(
                updatedItem.getUser_added_item()+ " updated new item in " + updatedItem.getPlant() + " - " + updatedItem.getItemname() + " " + updatedItem.getItembrand() + " - "
                        + updatedItem.getItemmodel() + " is " + updatedItem.getIsDamaged() + " which places in " + updatedItem.getLocation() + " identified by " + updatedItem.getHostname() + " or "
                        + updatedItem.getIp_address() + " is using by " + updatedItem.getUser_name() + " " + updatedItem.getOperator_number() + " working in " + updatedItem.getDepartment() + " department"
        );
        logs1 = toLogsEntity(logs);
        updatedItem.addLogToInvItem(logs1);

        itemsRepository.save(updatedItem);

        return ResponseEntity.ok(updatedItem);
    }

    private Logs toLogsEntity(Logs log) {
        Logs logs = new Logs();
        logs.setLogText(log.getLogText());
        return logs;
    }

//    Delete Item REst API
    @DeleteMapping("{id}")
    public ResponseEntity<Items> deleteItem(@PathVariable Long id){
        itemsRepository.deleteById(id);
        return new ResponseEntity<Items>(HttpStatus.OK);
    }
//GetAll the logs!
    @GetMapping("logs")
    public List<Logs> getAllLogs(){
        return logRepository.findAll();
    }

    @GetMapping("{id}/logs")
    public List<Logs> getLogsByItemId(@PathVariable Long id){
        return logRepository.getLogsByItem_Id(id);
    }

    // Get Images by Asset Model
    @GetMapping("{assetModel}/images")
    public List<Image> getAllImagesBuItemModel(@PathVariable String assetModel){
        return imageRepository.getImagesByAssets_AssetModel(assetModel);
    }



}
