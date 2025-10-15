package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public BasicItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * 전체 조회
     * @param model
     * @return
     */
    @GetMapping("")
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        log.info("items size = {}", items.size());
        model.addAttribute("items", items);

        return "basic/items";
    }

    /**
     *
     * 상품 등록페이지
     *
     * @return
     */
    @GetMapping("/add")
    public String addForm() {

        return "basic/addForm";
    }

    /**
     *
     * 상품 등록처리
     *
     * 여기서도 @ModelAttribute 로 받을 수 있다.
     * 당연한건 여기서 매핑되서 준 item 파라미터에는 id 값은 null 상태! ( 당연한거 )
     *
     * @return
     */
    @PostMapping("/add")
    public String addForm(@ModelAttribute Item item,
                          Model model) {

        Item nItem = new Item(item.getItemName(), item.getPrice(), item.getQuantity());
        itemRepository.save(nItem);

        model.addAttribute("item", nItem);

        return "basic/item";
    }

    /**
     * 특정 상품 조회
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {

        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    /**
     * 상품 수정 페이지
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {

        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    /**
     * 상품 수정
     *
     * 
     * @param itemId
     * @param model
     * @return
     */
    @PostMapping("/{itemId}/edit")
    public String editItem(@PathVariable Long itemId,
                           @ModelAttribute Item item,
                           Model model) {
    
        Item curItem = itemRepository.findById(itemId);

        // 참조형 타입이므로 그냥 이렇게만해도 이 Item 값은 리스트안에서도 수정되어있다.
        curItem.setItemName(item.getItemName());
        curItem.setPrice(item.getPrice());
        curItem.setQuantity(item.getQuantity());

        model.addAttribute("item", curItem);

        return "basic/item";
    }


    // 테스트용 데이터
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("물품 A", 10000, 1000));
        itemRepository.save(new Item("물품 B", 50000, 100));
        itemRepository.save(new Item("물품 C", 1000, 10000));
    }

    
}
