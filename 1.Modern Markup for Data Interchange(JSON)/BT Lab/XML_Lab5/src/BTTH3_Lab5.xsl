<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTTH3_Lab5.xsl
    Created on : August 21, 2020, 2:44 PM
    Author     : ADMIN
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>BTTH3_Lab5.xsl</title>
            </head>
            <body style="margin-top:40px">
                <table width="384" height="66" border="1" style="text-align:center;margin:auto;">
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Pages</th>
                        <th scope="col">Price</th>
                    </tr>
                    <xsl:for-each select="/BookList/book">
                        <!--sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="name" order="descending" />
                        <!--lọc các cuốn sách có giá trên $50 bằng xsl:if.-->
                        <xsl:if test="price >= 50">
                        <tr>
                            <td>
                                <xsl:value-of select="name" />
                            </td>
                            <td>
                                <xsl:value-of select="author" />
                            </td>
                            <td>
                                <xsl:value-of select="pages" />
                            </td>
                            <td>
                                <xsl:value-of select="price" />
                            </td>
                        </tr>
                        </xsl:if>
                    </xsl:for-each>
<!--                    <tr> Chỉ lấy ra hàng đầu tiên
                        <td>
                            <xsl:value-of select="/BookList/book/name" />
                        </td>
                        <td>
                            <xsl:value-of select="/BookList/book/author" />
                        </td>
                        <td>
                            <xsl:value-of select="/BookList/book/pages" />
                        </td>
                        <td>
                            <xsl:value-of select="/BookList/book/price" />
                        </td>
                    </tr>-->
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
