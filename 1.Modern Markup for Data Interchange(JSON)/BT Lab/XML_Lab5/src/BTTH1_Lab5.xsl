<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTTH1_Lab5.xsl
    Created on : August 21, 2020, 2:22 PM
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
                <title>BTTH1_Lab5.xsl</title>
            </head>
            <body style="text-align:center">
                <h3>My CD Collection</h3>
                <table border="1" width="400px" style="margin:auto">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:center">Title</th>
                        <th style="text-align:center">Artist</th>
                    </tr>
                    <xsl:for-each select="catalog/cd">
                        <tr>
                            <td style="text-align:center">
                                <xsl:value-of select="title"/>
                            </td>
                            <td style="text-align:center"> 
                                <xsl:value-of select="artist"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
