package chiarafais.u5w2d3.services;

import chiarafais.u5w2d3.entities.BlogPost;
import chiarafais.u5w2d3.exceptions.NotFoundException;
import chiarafais.u5w2d3.repositories.AutoriDAO;
import chiarafais.u5w2d3.repositories.BlogPostsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostsService {
    @Autowired
    private BlogPostsDAO blogPostRepository;
    @Autowired
    private AutoriDAO autoreRepository;

    public List<BlogPost> getBlogPostsList() {
        return blogPostRepository.findAll();
    }

    public BlogPost saveBlogPost(BlogPost body) {
        return blogPostRepository.save(body);
    }

    public BlogPost findById(int id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost) {
        BlogPost found = findById(id);
        found.setTitolo(updatedBlogPost.getTitolo());
        found.setContenuto(updatedBlogPost.getContenuto());
        return blogPostRepository.save(found);
    }

    public void findByIdAndDelete(int authorId) {
        blogPostRepository.deleteById(authorId);
    }
}
