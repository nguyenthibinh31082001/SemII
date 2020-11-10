<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BT_XSLT.xsl
    Created on : August 22, 2020, 9:29 PM
    Author     : Admin
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
                <title>BT_XSLT.xsl</title>
            </head>
            <body style="text-align:center">
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2 >Tất cả thông tin máy tính:</h2>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Producer</th>
                        <th scope="col">YearMaking</th>
                        <th scope="col">Price</th>
                    </tr>
                    <xsl:for-each select="/Computers/Computer">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <tr>
                            <td>
                            <xsl:value-of select="Name" />
                            </td>
                            <td>
                                <xsl:value-of select="Producer" />
                            </td>
                            <td>
                                <xsl:value-of select="YearMaking" />
                            </td>
                            <td>
                                <xsl:value-of select="Price" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2>Thông tin máy tính được sản xuất ở Malaysia:</h2>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Producer</th>
                        <th scope="col">YearMaking</th>
                        <th scope="col">Price</th>
                    </tr>
                    <xsl:for-each select="/Computers/Computer">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <xsl:if test="Producer[@from = 'Malaysia']">
                        <tr>
                            <td>
                            <xsl:value-of select="Name" />
                            </td>
                            <td>
                                <xsl:value-of select="Producer" />
                            </td>
                            <td>
                                <xsl:value-of select="YearMaking" />
                            </td>
                            <td>
                                <xsl:value-of select="Price" />
                            </td>
                        </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2>Thông tin máy tính có giá bán trên 600USD:</h2>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Producer</th>
                        <th scope="col">YearMaking</th>
                        <th scope="col">Price</th>
                    </tr>
                    <xsl:for-each select="/Computers/Computer">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <xsl:if test="Price > 600 ">
                        <tr>
                            <td>
                            <xsl:value-of select="Name" />
                            </td>
                            <td>
                                <xsl:value-of select="Producer" />
                            </td>
                            <td>
                                <xsl:value-of select="YearMaking" />
                            </td>
                            <td>
                                <xsl:value-of select="Price" />
                            </td>
                        </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2>Thông tin máy tính sản xuất năm 2018:</h2>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Producer</th>
                        <th scope="col">YearMaking</th>
                        <th scope="col">Price</th>
                    </tr>
                    <xsl:for-each select="/Computers/Computer">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <xsl:if test="YearMaking = 2018 ">
                        <tr>
                            <td>
                            <xsl:value-of select="Name" />
                            </td>
                            <td>
                                <xsl:value-of select="Producer" />
                            </td>
                            <td>
                                <xsl:value-of select="YearMaking" />
                            </td>
                            <td>
                                <xsl:value-of select="Price" />
                            </td>
                        </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
