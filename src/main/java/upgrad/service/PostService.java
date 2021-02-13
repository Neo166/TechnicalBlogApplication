package upgrad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgrad.model.Post;
import upgrad.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    @Autowired
    PostRepository repository;

    public List<Post> getAllPosts(){
        //ArrayList <Post> Posts = new ArrayList<>();

       /* Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();

        post1.setTitle("Post 1");
        post1.setBody("Post 1 Body");
        post1.setDate(new Date());

        post2.setTitle("Post 2");
        post2.setBody("Post 2 Body");
        post2.setDate(new Date());

        post3.setTitle("Post 3");
        post3.setBody("Post 3 Body");
        post3.setDate(new Date());

        Posts.add(post1);
        Posts.add(post2);
        Posts.add(post3);

        */

//       EntityManager em = emf.createEntityManager();
//
//        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
//        List<Post> resultList = query.getResultList();

//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","Neo166");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//            while (rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                Posts.add(post);
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        return repository.getAllPosts();
    }

    public Post getOnePost(){
//        ArrayList<Post> posts = new ArrayList<>();
//       /* Post post1 = new Post();
//        post1.setTitle("This is your Post");
//        post1.setBody("This is your Post. It has some valid content");
//        post1.setDate(new Date());
//        posts.add(post1);
//
//        */
//       Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","Neo166");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id = 4");
//            while (rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return repository.getLatestPost();
    }

    public void createPost(Post newPost){
        newPost.setDate(new Date()); //added date here.
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }

    public Post getPost(Integer postId){
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost){
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postID){
        repository.deletePost(postID);
    }

}
