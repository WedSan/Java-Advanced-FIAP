package fiap.checkpoint1.mapper;

import fiap.checkpoint1.dto.response.SingleBookCountResponseDTO;

public class BookCountMapper {

    public static SingleBookCountResponseDTO toDto(int bookCount) {
        return new SingleBookCountResponseDTO(bookCount);
    }
}
