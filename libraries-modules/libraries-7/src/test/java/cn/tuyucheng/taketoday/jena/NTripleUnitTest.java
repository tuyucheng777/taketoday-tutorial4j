package cn.tuyucheng.taketoday.jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.SchemaDO;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NTripleUnitTest {
   @Test
   void whenWeHaveAModel_ThenWeCanSerializeAsNTriples() {
      Model model = ModelFactory.createDefaultModel();

      model.createResource("/blog/posts/123")
            .addProperty(SchemaDO.headline, "Introduction to RDF and Apache Jena")
            .addProperty(SchemaDO.wordCount, "835")
            .addProperty(SchemaDO.author, model.createResource("/users/Tuyucheng")
                  .addProperty(SchemaDO.name, "Tuyucheng")
                  .addProperty(SchemaDO.url, "https://tuyucheng.com"))
            .addProperty(SchemaDO.comment, model.createResource("/blog/posts/123/comments/1")
                  .addProperty(SchemaDO.text, "What a great article!")
                  .addProperty(SchemaDO.author, model.createResource("/users/JoeBloggs")
                        .addProperty(SchemaDO.name, "Joe Bloggs")
                        .addProperty(SchemaDO.email, "joe.bloggs@example.com")));

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      RDFDataMgr.write(out, model, Lang.NTRIPLES);

      assertEquals("""
            </blog/posts/123/comments/1> <https://schema.org/author> </users/JoeBloggs> .
            </blog/posts/123/comments/1> <https://schema.org/text> "What a great article!" .
            </users/Tuyucheng> <https://schema.org/url> "https://tuyucheng.com" .
            </users/Tuyucheng> <https://schema.org/name> "Tuyucheng" .
            </users/JoeBloggs> <https://schema.org/email> "joe.bloggs@example.com" .
            </users/JoeBloggs> <https://schema.org/name> "Joe Bloggs" .
            </blog/posts/123> <https://schema.org/comment> </blog/posts/123/comments/1> .
            </blog/posts/123> <https://schema.org/author> </users/Tuyucheng> .
            </blog/posts/123> <https://schema.org/wordCount> "835" .
            </blog/posts/123> <https://schema.org/headline> "Introduction to RDF and Apache Jena" .
            """, out.toString());
   }
}